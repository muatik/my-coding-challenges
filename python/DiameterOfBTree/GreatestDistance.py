
class Diameter(object):
    def __init__(self, left, distanceLeft, right, distanceRight, diameter):
        super(Diameter, self).__init__()
        self.left = left
        self.right = right
        self.distanceRight = distanceRight
        self.distanceLeft = distanceLeft
        self.diameter = diameter

    def getMaxDistance(self):
        return max(self.distanceRight, self.distanceLeft)

    def getEndmostNode(self):
        if self.distanceLeft > self.distanceRight:
            return self.left
        else:
            return self.right

    def increaseBy(self, tree):
        if self.distanceLeft > self.distanceRight:
            self.right = tree
            self.distanceRight = 0
            self.distanceLeft += 1
        else:
            self.left = tree
            self.distanceLeft = 0
            self.distanceRight += 1

        self.diameter += 1

    def __str__(self):
        return "diameter length: {}, left: {},  right: {}".format(
            self.diameter, self.left.key, self.right.key
        )


def findDiameter(tree):
    if tree.left:
        leftSub = findDiameter(tree.left)
    if tree.right:
        rightSub = findDiameter(tree.right)

    if tree.left and tree.right:
        diameter = max(leftSub.diameter, rightSub.diameter)
        newPath = leftSub.getMaxDistance() + rightSub.getMaxDistance() + 2
        if newPath > diameter:
            r = Diameter(
                leftSub.getEndmostNode(),
                leftSub.getMaxDistance() + 1,
                rightSub.getEndmostNode(),
                rightSub.getMaxDistance() + 1,
                newPath
            )
        else:
            r = leftSub.diameter \
                if leftSub.diameter > rightSub.diameter else rightSub

    elif tree.left or tree.right:
        r = leftSub if tree.left else rightSub
        if r.getMaxDistance() + 1 > r.diameter:
            r.increaseBy(tree)
        else:
            r.distanceLeft += 1
            r.distanceRight += 1
    else:
        r = Diameter(
            tree,
            0,
            tree,
            0,
            0
        )

    return r
