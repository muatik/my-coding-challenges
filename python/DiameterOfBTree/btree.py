
class BTree(object):
    def __init__(self, key):
        super(BTree, self).__init__()
        self.right = None
        self.left = None
        self.key = key
        self.root = self

    def insert(self, key):
        if self.key > key:
            if self.left:
                self.left.insert(key)
            else:
                self.left = BTree(key)
        elif self.key < key:
            if self.right:
                self.right.insert(key)
            else:
                self.right = BTree(key)

    def display(self):
        if self.left:
            self.left.display()
        if self.right:
            self.right.display()
        print(self.key)

