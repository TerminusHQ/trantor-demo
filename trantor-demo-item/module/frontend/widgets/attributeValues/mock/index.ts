import { IField } from '@terminus/nusi-engine'

export const field = {
  label: "属性值",
  name: "attrVals", 
  isNullable: false, 
} as IField

export const actionApiPrefix = process.env.NUSI_ENGINE_API_PREFIX || '/t-project/eto'  

export const values = {
  valueType: "String",
  attrVals: ["1", "2", "3"]
}
  