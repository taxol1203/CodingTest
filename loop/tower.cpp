#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> heights) {
    vector<int> answer;
    int location = 0;
    //���� ���� ž���� Ȯ���Ѵ�
    for (int i = 0; i < heights.size(); i++) {
        //���� ž�� �������� �ϳ��� ã�� �ڱ⺸�� ���� ž�� ������ ��ġ ����ϰ� break;
        for (int j = i - 1; j >= 0; j--) {
            if (heights[j] > heights[i]) {
                location = j + 1;
                break;
            }
        }
        answer.push_back(location);
        location = 0;
    }
    return answer;
}


int main() {
    vector<int> returnVector = solution({ 6,9,5,7,4 });
    //int val = solution({ 2, 1, 3, 2 } , 2);

    //cout << val;

    for (int i = 0; i < returnVector.size(); i++)
        cout << returnVector.at(i) << " ";
    return 0;
}
