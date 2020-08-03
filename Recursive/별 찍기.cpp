#include <iostream>
#include <string>
using namespace std;

void MakeStar(int, char**, int, int);

int main() {

    ios::sync_with_stdio(false);
    cin.tie(NULL);
    int N = 0;
    cin >> N;
    char** star = new char* [N];
    for (int i = 0; i < N; i++)
        star[i] = new char[N];
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            star[i][j] = ' ';
        }
    }
    MakeStar(N, star, 0, 0);
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cout << star[i][j];
        }
        cout << "\n";
    }
    return 0;
}
void MakeStar(int N, char** star, int x, int y) {
    if (N == 1) {
        star[x][y] = '*';
        return;
    }
    N /= 3;
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (i == 1 && j == 1) {
                continue;
            }
            MakeStar(N, star, x + (N * i), y + (N * j));
        }
    }
}

