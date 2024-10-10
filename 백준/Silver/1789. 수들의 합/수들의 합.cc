#include <stdio.h>
#include <stdlib.h>
#include<iostream>
#pragma warning(disable:4996)
using namespace std;
typedef struct Node {
	int data;
	struct Node* link;
}Node;
Node* CreateNode(int data) {
	Node* newNode = (Node*)malloc(sizeof(Node));
	newNode->data = data;
	newNode->link = NULL;
}
int main() {
	long long s = 0;
	int n = 0;
	cin >> s;
	while (s > 0) {
		n++;
		s -= n;
	}
	if (s < 0)n--;
	cout << n << '\n';
	return 0;
}
