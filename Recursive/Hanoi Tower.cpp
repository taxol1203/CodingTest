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
    //�ش��ϴ� Ÿ���� ������ �ϳ� �ۿ� ������ ��ǥ ��ġ�� �ű��.
    if (N == 1) {
        cout << from << " " << to << "\n";
        return;
    }
    //n-1���� ž�� ����° Ÿ���� �Ű�ü�� �ι�° Ÿ���� �ű��
    hanoi(N - 1, from, mid, to);
    cout << from << " " << to << "\n";
    //�ι�° Ÿ������ ù��° Ÿ���� �Ű�ü�� ����° Ÿ���� �ű��
    hanoi(N - 1, mid, to, from);
}