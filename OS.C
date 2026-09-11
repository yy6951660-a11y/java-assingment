#include <stdio.h>              // Used for printf()
#include <stdlib.h>             // Used for general-purpose functions
#include <pthread.h>            // Used for creating and managing threads
#include <semaphore.h>          // Used for semaphores
#include <unistd.h>             // Used for sleep() if required


sem_t room;                     // Semaphore to control entry into the room
sem_t chopstick[5];             // Five semaphores representing five chopsticks


void eat(int phil);             // Function declaration for eat()


void *philosopher(void *num)    // Function executed by each philosopher thread
{
    int phil = *(int *)num;     // Get the philosopher number from the argument

    sem_wait(&room);            // Allow the philosopher to enter the room

    sem_wait(&chopstick[phil]); // Pick up the first chopstick

    sem_wait(&chopstick[(phil + 1) % 5]);
                                // Pick up the second chopstick
                                // %5 makes the arrangement circular

    eat(phil);                  // Philosopher eats after getting both chopsticks

    sem_post(&chopstick[(phil + 1) % 5]);
                                // Put down the second chopstick

    sem_post(&chopstick[phil]); // Put down the first chopstick

    sem_post(&room);            // Leave the room and allow another philosopher

    return NULL;                // End the philosopher thread
}


void eat(int phil)              // Function to display eating philosopher
{
    printf("\nPhilosopher %d is eating", phil);
                                // Print the philosopher number
}


int main()                      // Main function starts here
{
    int i, a[5];                // i is loop variable, a stores philosopher numbers

    pthread_t tid[5];           // Array to store five thread IDs


    sem_init(&room, 0, 4);      // Initialize room semaphore with value 4


    for(i = 0; i < 5; i++)      // Loop for five chopsticks
    {
        sem_init(&chopstick[i], 0, 1);
                                // Initialize each chopstick semaphore to 1
    }


    for(i = 0; i < 5; i++)      // Loop to create five philosopher threads
    {
        a[i] = i;               // Assign philosopher number 0,1,2,3,4

        pthread_create(&tid[i], NULL, philosopher, (void *)&a[i]);
                                // Create a thread for each philosopher
    }


    for(i = 0; i < 5; i++)      // Loop to wait for all five threads
    {
        pthread_join(tid[i], NULL);
                                // Wait until the philosopher thread finishes
    }


    return 0;                   // End the main program
}
