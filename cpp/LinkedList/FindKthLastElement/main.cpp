#include "LinkedList.cpp"



template<typename T>
T findLastElementAt(LinkedList<T> list, unsigned int position) {
    /*
    assuming that linked list implementation does not give the lengh of list.
    So, first we count items in the list, then locate the item at the
    given position.
    */

    // assuming the list is acyclic, otherwise this will be a infinite loop.
    Node<T> * current = list.getHead();
    unsigned int length = 0;
    while (current) {
        current = current->next;
        length++;
    }

    current = list.getHead();
    unsigned int index = 0;
    position = length - position - 1;
    while (current and index <= length) {
        if (position == index)
            return current->data;
        current = current->next;
        index++;
    }
    // throw an error
    return -99;
}


int main(int argc, char const *argv[])
{
    LinkedList<int> s;
    s.insert(4);
    s.insert(2);
    s.insert(1);
    s.insert(5);
    s.insert(9);
    s.insert(-2);
    s.insert(3);
    s.display();
    int a = findLastElementAt(s, -1);
    cout << a << endl;
    s.remove(2);
    s.display();

    // expected output:
    // -2, 1, 2, 3, 4, 5, 9,
    // -2, 1, 3, 4, 5, 9,
    return 0;
}