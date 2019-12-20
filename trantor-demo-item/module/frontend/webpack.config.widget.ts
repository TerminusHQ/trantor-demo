import * as merge from 'webpack-merge'
import * as CopyWebpackPlugin from 'copy-webpack-plugin'
import { isEmpty } from 'lodash'
import * as path from 'path'
import * as fs from 'fs'
import baseCofing from './webpack.config'
import * as infos from './debug/index.dist'

const widgetType = process.env.widget || 'input'
const { inputFile = '', showFile = '' } = infos || {} as any

const widgetMap = {
  input: {
    app: './test/index.widget.input.tsx',
    port: 8092,
    file: inputFile,
  },
  show: {
    app: './test/index.widget.show.tsx',
    port: 8093,
    file: showFile,
  }
}

const current = widgetMap[widgetType]

const plugins = []
if (!isEmpty(infos) && current.file) {
  const relativePath = current.file.replace('..', '.')
  const realPath = path.join(__dirname, relativePath);
  if (fs.existsSync(realPath)) {
    plugins.push(
      new CopyWebpackPlugin([
        { from: relativePath, to: './' },
      ]),
    )
  }
}

export default merge(baseCofing, {
  entry: {
    app: current.app,
  },
  devServer: {
    port: current.port,
  },
  plugins,
})
