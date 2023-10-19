#include <iostream>

// Define a Node structure for a singly linked list
struct Node {
    int data;
    Node* next;

    Node(int val) : data(val), next(nullptr) {}
};

// Function to merge two sorted linked lists
Node* merge(Node* &h1, Node* &h2) {
    // Create a dummy node to simplify the merging logic
    Node* dh = new Node(-1);
    Node* dt = dh;
    Node* t1 = h1;
    Node* t2 = h2;

    // Traverse both lists and merge them
    while (t1 != nullptr && t2 != nullptr) {
        if (t1->data < t2->data) {
            dt->next = t1;
            t1 = t1->next;
        } else {
            dt->next = t2;
            t2 = t2->next;
        }
        dt = dt->next;
    }

    // Append the remaining nodes of either list to the merged list
    if (t1 == nullptr) {
        dt->next = t2;
    } else {
        dt->next = t1;
    }

    // Get the head of the merged list
    Node* head = dh->next;
    delete dh;

    return head;
}

// Function to merge two sorted linked lists and return the merged list
Node* sortedMerge(Node* head1, Node* head2) {
    // Check for edge cases where one or both lists are empty
    if (head1 == nullptr) {
        return head2;
    }
    if (head2 == nullptr) {
        return head1;
    }

    // Call the merge function to merge the lists
    return merge(head1, head2);
}

// Function to print a linked list
void printList(Node* head) {
    Node* current = head;
    while (current != nullptr) {
        std::cout << current->data << " -> ";
        current = current->next;
    }
    std::cout << "nullptr" << std::endl;
}

int main() {
    // Create two sorted linked lists
    Node* head1 = new Node(1);
    head1->next = new Node(3);
    head1->next->next = new Node(5);

    Node* head2 = new Node(2);
    head2->next = new Node(4);
    head2->next->next = new Node(6);

    // Merge the two lists
    Node* mergedHead = sortedMerge(head1, head2);

    // Print the merged list
    std::cout << "Merged List: ";
    printList(mergedHead);

    // Clean up the memory
    delete head1;
    delete head2;
    // Delete nodes in the merged list to avoid memory leaks
    Node* current = mergedHead;
    while (current != nullptr) {
        Node* temp = current;
        current = current->next;
        delete temp;
    }

    return 0;
}
