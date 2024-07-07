#include <iostream>
using namespace std;
int arr[101];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);

    int n,m;
    cin >> n >> m;

    for (int i = 0; i <= n; ++i) {
        arr[i] = i;
    }

    int a,b;

    while (m-- > 0) {
        cin >> a >> b;
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    for (int i = 1; i <= n; i++) {
        cout << arr[i] << ' ';
    }
}
