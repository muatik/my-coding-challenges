#include "LinkedList.cpp"
#include "string"
template<typename T>
bool isCyclic(LinkedList<T> list) {
    Node<T> * current = list.getHead();
    Node<T> * next;
    while (current) {
        next = current->next;
        while (next) {
            cout << current << " = " << next << endl;
            if (current == next) {
                cout << "foun";
                return true;
            }
            next = next->next;
        }
        current = current->next;
    }
    return false;
}


int main(int argc, char const *argv[])
{
    LinkedList<string> s;
    Node<string> * a = new Node<string>();
    a->data = "john";
    Node<string> * b = new Node<string>();
    b->data = "mustafa";
    Node<string> * c = new Node<string>();
    s.insertNode(a);
    s.insertNode(b);
    s.display();
    // bool cyclic = isCyclic(s);
    // cout << "list is cyclic: " << cyclic << endl;
    // s.display();

    // expected output:
    // -2, 1, 2, 3, 4, 5, 9,
    // -2, 1, 3, 4, 5, 9,
    return 0;
}