#include <iostream>
#include <vector>

using namespace std;

vector<int> solution(vector<int> prices) {
    vector<int> answer;
    int count = 0;

    for (int i = 0; i < prices.size(); i++) {
        for (int j = i + 1; j < prices.size(); j++) {
            count++;
            if (prices.at(i) > prices.at(j)) {
                break;
            }
        }
        answer.push_back(count);
        count = 0;
    }
    return answer;
}

int main() {
    vector<int> returnVal;
    returnVal = solution({ 1, 2, 3, 2, 3, 3, 1 });

    for (int i = 0; i < returnVal.size(); i++)
        cout << returnVal.at(i) << " ";
    return 0;
}
