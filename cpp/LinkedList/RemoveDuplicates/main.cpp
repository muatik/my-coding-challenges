#include "LinkedList.cpp"

int main(int argc, char const *argv[])
{
    LinkedList<int> s;
    s.insert(4);
    s.insert(4);
    s.insert(2);
    s.insert(3);
    s.insert(8);
    s.insert(3);
    s.insert(1);
    s.insert(2);
    s.insert(3);
    s.insert(2);
    s.insert(2);
    s.insert(2);
    s.insert(2);
    s.display();
    s.removeDuplicates();
    s.display();
    // expected output:
    // -2, 1, 2, 3, 4, 5, 9,
    // -2, 1, 3, 4, 5, 9,
    return 0;
}