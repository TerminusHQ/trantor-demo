export interface IMenuItem {
  name: string // 显示名称
  icon?: string //  图标
  id?: string
  viewAction: string // 绑定视图
  children?: IMenuItem[] // 子节点
}

export interface IConfig {
  menu: IMenuItem[]
}
