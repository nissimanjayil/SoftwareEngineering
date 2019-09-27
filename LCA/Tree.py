from Node import Node;


 class Tree():
    def __init__(self, root = None):
        self.root = root
 
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: Node
        :type p: Node
        :type q: Node
        :rtype: Node
        """
 
        if not root or not p or not q:
            return None
 
        if root is p or root is q:
            return root
 
        # We are going to perform a single DFS to find both p and q
        # So, the time complexisty in worst case is O(n)
        lca, stack = [None], [root]
        found_one = False
        while stack:
            node = stack.pop()
 
            # Check if we are coming back up the tree.
            # If yes, just pop and continue the loop
            lca_popped = lca.pop()
            if lca_popped == node:
                if node == p or node == q:
                    found_one = False
            else:
                if lca_popped:
                    lca.append(lca_popped)
 
                if not found_one:
                    lca.append(node)
                    stack.append(node)
                    # Append the current node to stack  
                    # if we haven't yet found p or q.
 
                stack.extend(filter(None, [node.right, node.left]))
                # append right first, so left will be popped first  
 
                if node == p or node == q:
                    found_one = True
                    # Set p or q to None when found
                    if node == p:
                        p = None
                    if node == q:
                        q = None
 
            # Check if both p and q have been found
            if not p and not q:
                return lca.pop()
 
        return None
 
 
# Construct the tree
#
#         _______3______
#        /              \
#     ___5__          ___1__
#    /      \        /      \
#    6      _2       0       8
#          /  \
#          7   4
 
n7 = Node(7)
n5 = Node(5, Node(6), Node(2, n7, Node(4)))
n1 = Node(1, Node(0), Node(8))
root = Node(3, n5, n1)
 
t = Tree(root)
 
print('LCA of 5 & 7:')
result = t.lowestCommonAncestor(root, n5, n7)
if result:
    print(result.val)
else:
    print('None')
 
print('LCA of 5 & 1:')
result = t.lowestCommonAncestor(root, n5, n1)
if result:
    print(result.val)
else:
    print('None')

                                if __name__ == '__main__':
                                    main()
