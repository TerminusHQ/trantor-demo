import {state, PubSub, action, _, computed, Controller,utils}from 'nusi-sdk'
import { Toast } from '@terminus/nusi'

export default class extends Controller {
// 当字段值发生变化时触发以下方法
  onFieldChange = (filedName: string, value: string) => {
        if (filedName === 'staffName') {
            //对数据进行处理和判断
            console.log("staffMobile: " + value)
        }
    }
}