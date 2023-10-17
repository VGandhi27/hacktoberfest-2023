#include <iostream>

int main() {
    // Declare and initialize an array of integers
    int n[] = {1, 2, 3, 4, 5};

    // Calculate the length of the array
    int l = sizeof(n) / sizeof(n[0]);

    // Access and print elements of the array
    std::cout << "Elements of the array:" << std::endl;
    for (int i = 0; i < l; i++) {
        std::cout << "Element at index " << i << ": " << n[i] << std::endl;
    }

    // Calculate the sum of all elements in the array
    int sum = 0;
    for (int i = 0; i < l; i++) {
        sum += n[i];
    }
    std::cout << "Sum of all elements: " << sum << std::endl;

    // Find the maximum element in the array
    int max = n[0];
    for (int i = 1; i < l; i++) {
        if (n[i] > max) {
            max = n[i];
        }
    }
    std::cout << "Maximum element: " << max << std::endl;

    // Search for a specific element in the array
    int target = 3;
    bool found = false;
    for (int i = 0; i < l; i++) {
        if (n[i] == target) {
            found = true;
            break;
        }
    }

    if (found) {
        std::cout << "Element " << target << " found in the array." << std::endl;
    } else {
        std::cout << "Element " << target << " not found in the array." << std::endl;
    }

    return 0;
}
