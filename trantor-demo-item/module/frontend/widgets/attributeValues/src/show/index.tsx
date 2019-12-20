import React from 'react'
import { IWidgetProps } from '@terminus/nusi-engine'
// import './index.scss'

const Widget = (props: IWidgetProps) => {
  return <div>{JSON.stringify(props.value)}</div>
}
