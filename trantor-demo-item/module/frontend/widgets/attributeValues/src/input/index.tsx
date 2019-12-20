import React from 'react'
import { IWidgetProps } from '@terminus/nusi-engine'
import { Input } from '@terminus/nusi'
// import './index.scss'

const Widget = (props: IWidgetProps) => {
  return <Input value={JSON.stringify(props.value)} addonBefore={props.context.valueType} />
}

export default Widget
