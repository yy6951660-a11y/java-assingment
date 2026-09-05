class AccessChecker {

    static String classifyAccess(String fieldModifier, String accessorContext) {

        boolean allowed = false;

        if (fieldModifier.equals("private")) {

            // Only the declaring class can access private
            allowed = accessorContext.equals("SAME_CLASS");

        } else if (fieldModifier.equals("default")) {

            // Package-private: same class or same package
            allowed = accessorContext.equals("SAME_CLASS")
                    || accessorContext.equals("SAME_PACKAGE");

        } else if (fieldModifier.equals("protected")) {

            if (accessorContext.equals("SAME_CLASS")
                    || accessorContext.equals("SAME_PACKAGE")) {

                allowed = true;

            } else if (accessorContext.equals(
                    "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")) {

                // Cross-package subclass accessing through its own type
                allowed = true;

            } else if (accessorContext.equals(
                    "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE")) {

                // Cross-package subclass accessing through parent type
                allowed = false;
            }

        } else if (fieldModifier.equals("public")) {

            // Public is accessible everywhere
            allowed = true;
        }

        return allowed ? "ALLOWED" : "DENIED";
    }

    public static void main(String[] args) {

        System.out.println(
            classifyAccess(
                "protected",
                "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"
            )
        );

        System.out.println(
            classifyAccess(
                "protected",
                "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"
            )
        );

        System.out.println(
            classifyAccess(
                "private",
                "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"
            )
        );

        System.out.println(
            classifyAccess(
                "default",
                "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"
            )
        );
    }
}
