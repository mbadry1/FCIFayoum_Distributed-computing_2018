#include <mpi.h>;

int main(int argc, char* argv[]) {
	int size;
	int rank;
	int number;
	int tag = 0;

	// Initialize the MPI environment
    MPI_Init(&argc,&argv);

    // Get the number of processes
    MPI_Comm_size(MPI_COMM_WORLD, &size);

	// Get the rank of the process;
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);

	//Sending -1 from 0 to 1
	if (rank == 0) {
		number = -1;
		MPI_Send(&number, 1, MPI_INT, 1, tag, MPI_COMM_WORLD);
	} else if (rank == 1) {
		MPI_Recv(&number, 1, MPI_INT, 0, tag, MPI_COMM_WORLD,
				 MPI_STATUS_IGNORE);
		printf("Process 1 received number %d from process 0\n",
			   number);
	}

    // Finalize the MPI environment.
    MPI_Finalize();

	return 0;
}