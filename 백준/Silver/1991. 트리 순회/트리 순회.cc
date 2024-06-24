#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <map>
using namespace std;
pair <char, char> tree[100];
void preorder(char ch) {
	if (ch == '.')return;
	cout << ch;
	preorder(tree[ch - 'A'].first);
	preorder(tree[ch - 'A'].second);
}
void inorder(char ch) {
	if (ch == '.')return;
	inorder(tree[ch - 'A'].first);
	cout << ch;
	inorder(tree[ch - 'A'].second);
}
void postorder(char ch) {
	if (ch == '.')return;
	postorder(tree[ch - 'A'].first);
	postorder(tree[ch - 'A'].second);
	cout << ch;

}
int main() {
	cin.tie(0);
	ios_base::sync_with_stdio(0);
	int n;
	cin >> n;
	char root, left, right;
	for (int i = 0; i < n; i++) {
		cin >> root >> left >> right;
		root = root - 'A';
		tree[root].first= left;
		tree[root].second = right;
	}
	preorder('A');
	cout << '\n';
	inorder('A');
	cout << '\n';
	postorder('A');
	return 0;
}