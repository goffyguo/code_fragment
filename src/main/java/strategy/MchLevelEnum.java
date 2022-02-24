package strategy;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2022/02/24/14:30
 * @Description:
 */
public enum MchLevelEnum {

    /**
     * 一级商户
     */
    FIRST_MCH(1),

    /**
     * 二级商户
     */
    SECOND_MCH(2);


    private final int level;



    MchLevelEnum(int level) {
        this.level = level;
    }


    public int getLevel() {
        return level;
    }

    public static MchLevelEnum getEnum(Integer level){
        if (level == null){
            return null;
        }
        for (MchLevelEnum mchLevelEnum : values()) {
            if (mchLevelEnum.getLevel() == level) {
                return mchLevelEnum;
            }
        }
        return null;
    }
}
