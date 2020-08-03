#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    vector<int> date;
    //�� �ϸ��� �ɸ��� ��¥ ����
    for (int i = 0; i < progresses.size(); i++) {
        if ((100 - progresses[i]) % speeds[i] == 0) {
            date.push_back((100 - progresses[i]) / speeds[i]);
        }
        else {
            date.push_back((100 - progresses[i]) / speeds[i] + 1);
        }
    }

    int progressing = 0;
    for (int i = 0; i < progresses.size(); i++) {
        //ó�� �� ��
        if (answer.empty()) {
            progressing = date[i];
            answer.push_back(1);
        }
        //���� ���� ���� ���� ���� �� ���� ���� ���� ��
        else if (date[i] <= progressing) {
            answer.back()++;
        }
        else {
            progressing = date[i];
            answer.push_back(1);
        }
    }

    return answer;
}

vector<int> better_solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    int day;
    int maxday = 0;
    for (int i = 0; i < progresses.size(); i++) {
        //100���� 1���� ���ڸ� ���־� 30���� 30 3���� �ϰ� ��.
        day = (99 - progresses[i]) / speeds[i] + 1;

        //���� ���� ���� �� ���� ���� ��
        if (day > maxday) {
            answer.push_back(1);
            maxday = day;
        }
        else {
            answer.back()++;
        }
    }

    return answer;
}

int main() {
    vector<int> returnVector = better_solution({ 93,30,55 }, { 1,30,5 });
    //int val = solution({ 2, 1, 3, 2 } , 2);

    //cout << val;

    for (int i = 0; i < returnVector.size(); i++)
        cout << returnVector.at(i) << " ";
    return 0;
}
