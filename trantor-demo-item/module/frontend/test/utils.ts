interface INode {
  children?: INode[]
}

export const mapTree = <T extends INode, N extends INode>(nodes: T[], fun: (node: T) => N) => {
  const results: N[] = []
  nodes.forEach((n) => {
    const to = fun(n)
    if (n.children && n.children.length) {
      to.children = mapTree(n.children, fun)
    }
    results.push(to)
  })
  return results
}
