
#include <iostream>
#include <string>
using namespace std;

int main() {

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    int N = 0;
    cin >> N;
    int money = 0;
    cin >> money;
    int* coin = new int[N];
    for (int i = 0; i < N; i++) {
        cin >> coin[i];
    }
    int curCoin = 1;
    int cnt = 0;
    int usedC = 0;
    while (money) {
        for (int i = 0; i < N; i++) {
            //현재 동전 보다 금액이 적으면 그 전 동전으로 계산
            if (coin[i] > money) {
                curCoin = coin[i - 1];
                break;
            }
            //주어진 금액이 동전 최고 금액 보다 비쌀 때
            else {
                curCoin = coin[i];
            }
        }
        usedC = money / curCoin;
        money -= usedC * curCoin;
        cnt += usedC;
    }
    cout << cnt;
    return 0;
}