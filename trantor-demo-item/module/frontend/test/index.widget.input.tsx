import './global.amd'
import React from 'react'
import { render } from 'react-dom'
import { get, isEmpty } from 'lodash'
import { FormBuilder, Button } from '@terminus/nusi'
import { computed, set, toJS, observable } from 'mobx'
import { observer } from 'mobx-react'
import { IField } from '@terminus/nusi-engine'
import { calcDisplay } from '@terminus/nusi-engine/lib/base/action'
import { getValidator } from '@terminus/nusi-engine/lib/base/field'
import { FieldType } from '@terminus/nusi-engine/lib/types/field'
import { inputFile } from '../debug/index.dist'
import * as Infos from '../debug/index.widget'

const { Fields, Actions } = FormBuilder
const { WidgetInput: Widget , field, actionApiPrefix, values } = Infos || {}
const pathList = inputFile ? inputFile.split('/') : ''
const realPath = pathList[pathList.length - 1]

const controlledMiddleware = () => (moduleKey?: string): any => {
  let preifxUrl = ''
  const realModuleKey = moduleKey || ''
  if (!realModuleKey) {
    preifxUrl = `${actionApiPrefix}`
  }
  preifxUrl = `${actionApiPrefix}/${realModuleKey.toLocaleLowerCase()}`
  return (request: any) => {
    if (request.url[0] === '/') {
      request.url = preifxUrl + request.url
    }
    return request
  }
}

@observer
class App extends React.Component {
  form: any

  @observable
  protected data = values

  @observable
  protected DynamicComp: any = null

  componentDidMount () {
    window.require([realPath], (Comp: any) => {
      this.DynamicComp = Comp
    })
  }

  public getDefaultValue(field: IField, data: any) {
    const { name, defaultValue } = field
    if (!name) return undefined
    const value = get(data, name!)
    if (field.type === FieldType.Boolean) {
      return value === true || defaultValue === true
    }
    return value === undefined ? defaultValue : value
  }

  @computed get fields() {
    const { label, name, isNullable } = field
    const data = toJS(this.data)
    const display = calcDisplay(field)
    const base = {
      type: Widget,
      required: isNullable === false,
      validator: getValidator(field),
      customProps: { field, context: data, controlledMiddleware },
      initialValue: this.getDefaultValue(field, data),
      label,
      onFieldChange: this.onFieldChange,
      name,
      show: () => display,
    }
    const list =  [base]
    if (this.DynamicComp) {
      list.push({ ...base, label: `${label}-动态加载`, name: `${name}-dist`,type: this.DynamicComp})
    }
    return list
  }

  public onFieldChange = (_val: any, { formData }: any) => {
    set(this.data, formData)
  }

  render() {
    if (isEmpty(Infos) || !Widget || !field) {
      return `[ERROR]: 编辑态单个组件调试
请在debug/index.widget.tsx正确的export Widget、field`
    }
    return (
      <FormBuilder
        wrappedComponentRef={(ref: any) => this.form = ref}
        layout='vertical'
      >
        <Fields fields={this.fields} colSpan={12} />
        <Actions>
          <Button type="secondary" htmlType="submit">
            保存
          </Button>
        </Actions>
      </FormBuilder>
    )
  } 
}

render(<App />, document.getElementById('app')!)
