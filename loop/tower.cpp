#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> heights) {
    vector<int> answer;
    int location = 0;
    //제일 앞의 탑부터 확인한다
    for (int i = 0; i < heights.size(); i++) {
        //현재 탑의 왼쪽으로 하나씩 찾아 자기보다 높은 탑이 나오면 위치 기록하고 break;
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
