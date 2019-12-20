import './global.amd'
import React from 'react'
import { render } from 'react-dom'
import { isEmpty } from 'lodash'
import { Panel } from '@terminus/nusi'
import { computed, toJS, observable } from 'mobx'
import { observer } from 'mobx-react'
import { calcDisplay } from '@terminus/nusi-engine/lib/base/action'
import { showFile } from '../debug/index.dist'
import * as Infos from '../debug/index.widget'

const { WidgetShow: Widget, field, values } = Infos || {};
const pathList = showFile ? showFile.split('/') : ''
const realPath = pathList[pathList.length - 1]

@observer
class App extends React.Component {
  @observable
  protected data = values

  @observable
  protected DynamicComp: any = null

  componentDidMount () {
    window.require([realPath], (Comp: any) => {
      this.DynamicComp = Comp
    })
  }

  @computed get fields() {
    const { label, name } = field
    const context = toJS(this.data)
    const display = calcDisplay(field)
    const base = {
      ...field,
      valueKey: name,
      label,
      hide: !display,
      valueItem: ({ value }: any) => {
        return (
          <Widget
            field={field}
            context={context}
            value={value}
          />
        )
      },
    }
    const list = [base]
    const Comp = this.DynamicComp
    if (this.DynamicComp) {
      list.push({ 
        ...base, 
        label: `${label}-动态加载`, 
        valueKey: `${name}-dist`,
        valueItem: ({ value }: any) => {
          return (
            <Comp
              field={field}
              context={context}
              value={value}
            />
          )
        }
      })
    }
    return list
  }

  render() {
    if (isEmpty(Infos) || !Widget || !field) {
      return `[ERROR]: 展示态单个组件调试 /n 请在debug/index.widget.tsx正确的export Widget、field`
    }
    return (
      <Panel
        fields={this.fields}
        data={toJS(this.data)} 
        isMultiColumn 
        layout='horizontal' 
        type='Z'
      />
    )
  } 
}

render(<App />, document.getElementById('app')!)
