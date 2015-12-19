#include "SortedLinkedList.h"
#include "iostream"

using namespace  std;

template<typename T>
SortedLinkedList<T>::SortedLinkedList() {};

template<typename T>
SortedLinkedList<T>::~SortedLinkedList() {};

template<typename T>
void SortedLinkedList<T>::insert(T data) {
    Node<T> * newNode = new Node<T>();
    newNode->data = data;

    if (isEmpty() || head->data > data) {
        newNode->next = head;
        head = newNode;
        return;
    }

    Node<T> * current = head;
    while (current->next && current->next->data < data) {
        current = current->next;
    }
    newNode->next = current->next;
    current->next = newNode;
}

template<typename T>
void SortedLinkedList<T>::remove(T data) {
    Node<T> * current = head;
    while (current) {
        if (current->next && current->next->data == data) {
            current->next = current->next->next;
            break;
        }
        current = current->next;
    }
}

template<typename T>
bool SortedLinkedList<T>::isEmpty() {
    return  head == NULL? true : false;
}

template<typename T>
bool SortedLinkedList<T>::exists(T data) {
    Node<T> * current = head;
    while (current) {
        if (current->data == data)
            return true;
        current = current->next;
    }
    return false;
}


template<typename T>
void SortedLinkedList<T>::display() {
    Node<T> * current = head;
    while (current) {
        cout << current->data << ", ";
        current = current->next;
    }
    cout << endl;
}
