package lotto.Model;

import lotto.Constants;

public class LottoAmountValidator {
    public final String amountOfLottoBeforeValidate;
    public int parsedAmountOfLotto;
    public LottoAmount lottoAmount;

    public LottoAmountValidator(String amountOfLottoBeforeValidate){
        this.amountOfLottoBeforeValidate = amountOfLottoBeforeValidate;
        validate();
    }
    private void validate(){
        validateBlank();
        validateContainsString();
        validateThousandUnit();
    }
    private void validateBlank(){
        if(this.amountOfLottoBeforeValidate.isBlank() || this.amountOfLottoBeforeValidate.isEmpty()){
            throw new IllegalArgumentException(String.join(Constants.ERROR,Constants.LOTTO_AMOUNT_BLANK_ERROR));
        }
    }
    private void validateContainsString(){
        try{
            this.parsedAmountOfLotto = Integer.parseInt(this.amountOfLottoBeforeValidate);
        }catch (Exception e){
            throw new IllegalArgumentException(String.join(Constants.ERROR,Constants.LOTTO_AMOUNT_CONTAINS_STRING_ERROR));
        }
    }
    private void validateThousandUnit() {
        if (this.parsedAmountOfLotto % 1000 != 0) {
            throw new IllegalArgumentException(String.join(Constants.ERROR, Constants.LOTTO_AMOUNT_UNIT_ERROR));
        }
        this.lottoAmount = new LottoAmount(this.parsedAmountOfLotto / 1000);
    }
}