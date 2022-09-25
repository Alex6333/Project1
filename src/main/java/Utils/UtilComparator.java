package Utils;

import Comparators.*;
import enums.StudentsComparatorEnum;
import enums.UniversityComparatorEnum;

public class UtilComparator {

    public UtilComparator() {
    }

    public static StudentComparator getStudentComparator(StudentsComparatorEnum studentsComparatorEnum) {

        switch (studentsComparatorEnum) {
            case FULL_NAME:
                return new StudentFullNameComparator();
            case UNIVERSITY_ID:
                return new StudentUniversityIdComparator();
            case AVG_EXAM_SCORE:
                return new StudentAvgExamScoreComparator();
            case CURRENT_COURSE_NUMBER:
                return new StudentCurrentCourseNumberComparator();
            default:
                return new StudentFullNameComparator();
        }
    }

    public static UniversityComparator getUniversityComparator(UniversityComparatorEnum universityComparatorEnum) {

        switch (universityComparatorEnum) {
            case FULL_NAME:
                return new UniversityFullNameComparator();
            case ID:
                return new UniversityIdComparator();
            case SHORT_NAME:
                return new UniversityShortNameComparator();
            case MAIN_PROFILE:
                return new UniversityMainProfileComparator();
            case YEAR_OF_FOUNDATION:
                return new UniversityYearOfFoundationComparator();
            default:
                return new UniversityFullNameComparator();
        }
    }
}
