#include <bits/stdc++.h>
using namespace std;

int arr[1000000];

void countSort(int n, int a[], int k)
{
    int c[k + 1];
    int b[n + 1];

    for (int i = 0; i <= k; i++)
        c[i] = 0;

    for (int i = 0; i < n; i++)
    {
        c[a[i]]++;
    }

    for (int i = 1; i <= k; i++)
    {
        c[i] += c[i - 1];
    }

    for (int i = n - 1; i >= 0; i--)
    {
        b[(--c[a[i]])] = a[i];
    }

    for (int i = 0; i < n; i++)
    {
        a[i] = b[i];
    }
}

int main()
{

    int n, i;
    cout << "Enter number of elements in array : ";
    cin >> n;

    srand(time(NULL));
    int mx = -1;

    for (i = 1; i <= n; i++)
    {
        arr[i] = (rand() % 10);
        mx = max(mx, arr[i]);
    }

    clock_t t;
    t = clock();

    countSort(n, arr, mx);

    t = clock() - t;
    double time_taken = ((double)t) / CLOCKS_PER_SEC;

    // Printing sorted elements

    for (int i = 0; i < n; i++)
    {
        // cout << arr[i] << " ";
    }


    cout << endl << endl << "countSort() took " << time_taken << " seconds to execute. \n" << endl;
    return 0;
}