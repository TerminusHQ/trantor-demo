import { Icon, Shell } from '@terminus/nusi'
import React, { ReactNode } from 'react'

import { IMenuItem } from './types'
import { mapTree } from './utils'

interface IProps {
  menus: IMenuItem[]
  children?: ReactNode
  onMenuItemClick?: (item: IMenuItem) => void
}

export default ({ menus, onMenuItemClick, children }: IProps) => {
  let i = 0
  const itemMap: { [key: number]: IMenuItem } = {}
  const dataSource = mapTree(menus, (item) => {
    const { icon, name } = item
    itemMap[i] = item
    return {
      key: i++,
      icon,
      title: name,
      children: undefined,
    }
  })

  return (
    <div style={{ height: '100vh' }}>
      <Shell
        globalNavigation={{
          userMenu: {
            avatar: {
              icon: 'yonghuzhongxin',
            },
          },
          className: 'terminus-sap anticon-user',
        }}
        sideNavigation={{
          onTitleClick: ({ selectedKey }: any) => {
            return onMenuItemClick && onMenuItemClick(itemMap[selectedKey])
          },
          dataSource,
        }}
      >
        {children}
      </Shell>
    </div >
  )
}
