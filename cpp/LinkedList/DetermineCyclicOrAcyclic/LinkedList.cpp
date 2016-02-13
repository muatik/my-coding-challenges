#include "LinkedList.h"
#include "iostream"

using namespace  std;

template<typename T>
LinkedList<T>::LinkedList() {};

template<typename T>
LinkedList<T>::~LinkedList() {};

template<typename T>
void LinkedList<T>::insert(T data) {
    Node<T> * newNode = new Node<T>();
    newNode->data = data;
    newNode->next = head;
    head = newNode;
}

template<typename T>
void LinkedList<T>::insertNode(Node<T> * node) {
    node->next = head;
    head = node;
}

template<typename T>
void LinkedList<T>::remove(T data) {
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
bool LinkedList<T>::isEmpty() {
    return  head == NULL? true : false;
}

template<typename T>
bool LinkedList<T>::exists(T data) {
    Node<T> * current = head;
    while (current) {
        if (current->data == data)
            return true;
        current = current->next;
    }
    return false;
}


template<typename T>
Node<T> * LinkedList<T>::getHead() {
    return head;
}

template<typename T>
void LinkedList<T>::display() {
    Node<T> * current = head;
    while (current) {
        cout << current->data << ", ";
        current = current->next;
    }
    cout << endl;
}
