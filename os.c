#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>

int main()
{
    int pid, n, oddsum = 0, evensum = 0;

    printf("Enter the value of n: ");
    scanf("%d", &n);

    pid = fork();

    if(pid == 0)
    {
        for(int i = 1; i <= n; i++)
        {
            if(i % 2 != 0)
                oddsum = oddsum + i;
        }

        printf("Sum of odd numbers: %d\n", oddsum);
    }
    else
    {
        wait(NULL);

        for(int i = 1; i <= n; i++)
        {
            if(i % 2 == 0)
                evensum = evensum + i;
        }

        printf("Sum of even numbers: %d\n", evensum);
    }

    return 0;
}
