#include <iostream>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);

    int t;
    cin >> t;

    int a,b;

    while (t-- > 0) {
        cin >> a >> b;
        cout << a + b << '\n';
    }
}