#include "SortedLinkedList.cpp"

int main(int argc, char const *argv[])
{
    SortedLinkedList<int> s;
    s.insert(4);
    s.insert(2);
    s.insert(1);
    s.insert(5);
    s.insert(9);
    s.insert(-2);
    s.insert(3);
    s.display();


    s.remove(2);
    s.display();

    // expected output:
    // -2, 1, 2, 3, 4, 5, 9,
    // -2, 1, 3, 4, 5, 9,
    return 0;
}