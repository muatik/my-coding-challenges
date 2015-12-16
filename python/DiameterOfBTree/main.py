from btree import BTree
from GreatestDistance import findDiameter

t = BTree("h")
t.insert("d")
t.insert("f")
t.insert("a1")
t.insert("a2")
t.insert("a3")
t.insert("a4")
t.insert("m1")
t.insert("m2")
t.insert("m3")
t.insert("m4")
t.display()

print findDiameter(t)
