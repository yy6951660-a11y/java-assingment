class MovieBookingProfile {

    private String name;
    private boolean confirmed;
    private String otp;

    // Public no-argument constructor
    public MovieBookingProfile() {
        confirmed = false;
    }

    // Convenience constructor
    public MovieBookingProfile(String name) {
        this();
        this.name = name;
    }

    // JavaBean getter/setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // JavaBean getter/setter for confirmed
    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    // Write-only OTP property
    public void setOtp(String otp) {
        this.otp = otp;
    }
}
