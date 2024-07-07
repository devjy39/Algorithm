#include <iostream>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0); // 입력 버퍼 제거 속도 최적화

    int t;
    cin >> t;

    while (t-- > 0) {
        cout << "hello" << '\n'; // 출력 시 개행 \n 최적화
    }
}