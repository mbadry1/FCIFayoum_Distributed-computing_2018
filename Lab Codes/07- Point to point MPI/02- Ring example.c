#include <mpi.h>;

int main(int argc, char* argv[]) {
	int size;
	int rank;
	int number;
	int tag = 0;
	int token;

	// Initialize the MPI environment
    MPI_Init(&argc,&argv);

    // Get the number of processes
    MPI_Comm_size(MPI_COMM_WORLD, &size);

	// Get the rank of the process;
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);

	//Receving a message from the previous rank
	if (rank != 0) {
		MPI_Recv(&token, 1, MPI_INT, rank - 1, 0,
				 MPI_COMM_WORLD, MPI_STATUS_IGNORE);
		printf("Process %d received token %d from process %d\n",
			   rank, token, rank - 1);
	} else {
		// Set the token's value if you are process 0
		token = -1;
	}
	MPI_Send(&token, 1, MPI_INT, (rank + 1) % size,
			 0, MPI_COMM_WORLD);

	// Now process 0 can receive from the last process.
	if (rank == 0) {
		MPI_Recv(&token, 1, MPI_INT, size - 1, 0,
				 MPI_COMM_WORLD, MPI_STATUS_IGNORE);
		printf("Process %d received token %d from process %d\n",
			   rank, token, size - 1);
	}

    // Finalize the MPI environment.
    MPI_Finalize();

	return 0;
}