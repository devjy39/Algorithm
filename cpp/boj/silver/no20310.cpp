#include <iostream>
using namespace std;
int count[2];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);

    string str;
    cin >> str;

    int zero = 0;
    for (char c: str) {
        if(c=='0') {
            zero++;
        }
    }

    int one = (str.size() - zero) >> 1;
    zero = zero >> 1;

    for (char c: str) {
        if(c=='0') {
            if(zero-- > 0) {
                cout << 0;
            }
        } else {
            if(one-- <= 0) {
                cout << 1;
            }
        }
    }
}
