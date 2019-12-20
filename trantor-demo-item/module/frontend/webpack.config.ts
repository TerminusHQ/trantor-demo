import * as HtmlWebpackPlugin from 'html-webpack-plugin'
import * as path from 'path'
import 'webpack-dev-server'
import * as merge from 'webpack-merge'
import baseCofing from './webpack.config.base'
import { host, proxyActionApiPrefix, proxyStoreApi, NUSI_ENGINE_API_PREFIX } from './debug/setting'

const publicPath = path.join(__dirname, '/public')

const actionApiPrefix = NUSI_ENGINE_API_PREFIX || process.env.NUSI_ENGINE_API_PREFIX || '/t-project/eto'

export default merge({
  // devtool: 'cheap-module-eval-source-map',
  entry: {
    app: './test/index.mix.tsx',
  },
  output: {
    path: publicPath,
    filename: '[name].js',
    publicPath: '/',
    libraryTarget: 'umd',
  },
  devServer: {
    contentBase: path.join(__dirname, 'public'),
    compress: true,
    historyApiFallback: {
      disableDotRule: true,
    },
    open: true,
    port: 8091,
    host,
    proxy: {
      [actionApiPrefix]: {
        target: proxyActionApiPrefix,
        secure: false,
        changeOrigin: true,
      },
      '/api': {
        target: proxyStoreApi,
        secure: false,
        changeOrigin: true,
      },
    },
  },
  plugins: [
    new HtmlWebpackPlugin({
      chunks: ['app'],
      filename: 'index.html',
      template: './test/index.ejs',
      actionApiPrefix,
      hash: true,
    }),
  ],
  optimization: {
    minimize: false,
    namedChunks: true,
    namedModules: true,
  },
}, baseCofing)
