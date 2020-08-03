#include <iostream>
#include <string>
using namespace std;

void hanoi(int, int, int, int);

int main() {

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    int N = 0;
    cin >> N;
    hanoi(N, 1, 3, 2);
    return 0;
}

void hanoi(int N, int from, int to, int mid) {
    //해당하는 타워에 원판이 하나 밖에 없으면 목표 위치로 옮긴다.
    if (N == 1) {
        cout << from << " " << to << "\n";
        return;
    }
    //n-1개의 탑을 세번째 타워를 매개체로 두번째 타워에 옮긴다
    hanoi(N - 1, from, mid, to);
    cout << from << " " << to << "\n";
    //두번째 타워들을 첫번째 타워를 매개체로 세번째 타워에 옮긴다
    hanoi(N - 1, mid, to, from);
}