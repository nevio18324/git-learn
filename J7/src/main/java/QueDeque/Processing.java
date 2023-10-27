package QueDeque;

public class Processing implements ProcessingInterface {
    Job[] jobs;
    /**
     * Add a job to the system.
     *
     * @return true if the job is added.
     */
    public boolean addJob(Job job) {
        if (jobs != null){
            Job[] newJobs = new Job[jobs.length + 1];
            System.arraycopy(jobs,0,newJobs,1,jobs.length);
            newJobs[0] = job;
            jobs = newJobs;
            return true;
        }else {
            jobs = new Job[]{job};
            return true;
        }
        // TODO: implement this method
    }

    /**
     * Get the next job for processing.
     */
    public Job getNextJob() {
        if (jobs != null){
            try {
                Job nextJob = jobs[jobs.length - 1];
                Job [] newJobs = new Job[jobs.length - 1];
                System.arraycopy(jobs,0,newJobs,0,jobs.length - 1);
                jobs = newJobs;
                return nextJob;
            }catch (Exception NomMoreJobs){
                return null;
            }
        }
        return null;
    }

    /**
     * Put the unprocessed job back to the system.
     */
    public void getJobBack(Job job) {
        // TODO: implement this method
    }

    /**
     * Get the number of jobs in the system.
     */
    public int getJobs() {
        if (jobs != null) {
            return jobs.length;
        }
        // TODO: implement this method
        return 0;
    }

    /**
     * Has jobs in the system for processing?
     */
    public boolean hasJobs() {
        // TODO: implement this method
        return false;
    }
}