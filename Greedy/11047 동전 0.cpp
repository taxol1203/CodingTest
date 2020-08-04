
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
            //���� ���� ���� �ݾ��� ������ �� �� �������� ���
            if (coin[i] > money) {
                curCoin = coin[i - 1];
                break;
            }
            //�־��� �ݾ��� ���� �ְ� �ݾ� ���� ��� ��
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