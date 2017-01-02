package hib.service.impl;

import hib.ora.dao.BaseDAO;
import hib.ora.entity.Birthdate;
import hib.service.BirthdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("BirthDateService")
public class BirthdateServiceImpl implements BirthdateService {
    @Autowired
    BaseDAO<Birthdate> baseDAO;

    public int category = 0;
    public int suman = 0;
    public int sumb1n = 0;
    public int sumb2n = 0;
    public int sumcn = 0;
    public int sumdn = 0;
    public int sumen = 0;
    public int sumas = 0;
    public int sumb1s = 0;
    public int sumb2s = 0;
    public int sumcs = 0;
    public int sumds = 0;
    public int sumes = 0;

    public int sumBn = 0;
    public int sumBs = 0;

    public int categoryBehind = 0;
    public int sumanBehind = 0;
    public int sumb1nBehind = 0;
    public int sumb2nBehind = 0;
    public int sumcnBehind = 0;
    public int sumdnBehind = 0;
    public int sumenBehind = 0;
    public int sumasBehind = 0;
    public int sumb1sBehind = 0;
    public int sumb2sBehind = 0;
    public int sumcsBehind = 0;
    public int sumdsBehind = 0;
    public int sumesBehind = 0;

    public int sumBnBehind = 0;
    public int sumBsBehind = 0;

    @Override
    public List<Birthdate> find(String hql, List<Object> param) {

        return baseDAO.find(hql, param);

    }

    public List<Birthdate> findSql(String sql) {

        return baseDAO.findSql(sql);

    }

    public Birthdate getUserBirthInfo(String date, String time) {

        String Sql = "from Birthdate where startdate < STR_TO_DATE(?, '%Y-%m-%d %H:%i:%s') and enddate > STR_TO_DATE(?, '%Y-%m-%d %H:%i:%s')";

        List<Object> param = new ArrayList<Object>();

        String datetime = null;

        if (time.equalsIgnoreCase("")) {
            datetime = date + " 00:00:00";
        } else {
            datetime = date + " " + time;
        }

        param.add(datetime);

        param.add(datetime);

        List<Birthdate> list = this.find(Sql, param);

        if (list.size() > 0 && list.get(0) != null) {

            category = list.get(0).getCategory();
            suman = list.get(0).getSuman();
            sumb1n = list.get(0).getSumb1n();
            sumb2n = list.get(0).getSumb2n();
            sumcn = list.get(0).getSumcn();
            sumdn = list.get(0).getSumdn();
            sumen = list.get(0).getSumen();
            sumas = list.get(0).getSumas();
            sumb1s = list.get(0).getSumb1s();
            sumb2s = list.get(0).getSumb2s();
            sumcs = list.get(0).getSumcs();
            sumds = list.get(0).getSumds();
            sumes = list.get(0).getSumes();

            sumBn = sumb1n + sumb2n;
            sumBs = sumb1s + sumb2s;

            return list.get(0);
        } else {
            return null;
        }
    }

    public Birthdate getSysdateInfo(String date, String time) {

        String Sql = "from Birthdate where startdate < STR_TO_DATE(?, '%Y-%m-%d %H:%i:%s') and enddate > STR_TO_DATE(?, '%Y-%m-%d %H:%i:%s')";

        List<Object> param = new ArrayList<Object>();

        String datetime = null;

        if (time.equalsIgnoreCase("")) {
            datetime = date + " 00:00:00";
        } else {
            datetime = date + " " + time;
        }

        param.add(datetime);

        param.add(datetime);

        List<Birthdate> list = this.find(Sql, param);

        if (list.size() > 0 && list.get(0) != null) {

            categoryBehind = list.get(0).getCategory();
            sumanBehind = list.get(0).getSuman();
            sumb1nBehind = list.get(0).getSumb1n();
            sumb2nBehind = list.get(0).getSumb2n();
            sumcnBehind = list.get(0).getSumcn();
            sumdnBehind = list.get(0).getSumdn();
            sumenBehind = list.get(0).getSumen();
            sumasBehind = list.get(0).getSumas();
            sumb1sBehind = list.get(0).getSumb1s();
            sumb2sBehind = list.get(0).getSumb2s();
            sumcsBehind = list.get(0).getSumcs();
            sumdsBehind = list.get(0).getSumds();
            sumesBehind = list.get(0).getSumes();

            sumBnBehind = sumb1nBehind + sumb2nBehind;
            sumBsBehind = sumb1sBehind + sumb2sBehind;

            return list.get(0);
        } else {
            return null;
        }
    }

    public List<Birthdate> getYearInfo(String date, String time) {

        String Sql = "from Birthdate where year = ? order by category";

        List<Object> param = new ArrayList<Object>();

        String datetime = null;

        if (time.equalsIgnoreCase("")) {
            datetime = date + " 00:00:00";
        } else {
            datetime = date + " " + time;
        }

        datetime = datetime.substring(0, 4);

        param.add(datetime);

        List<Birthdate> list = this.find(Sql, param);

        if (list.size() > 0 && list.get(0) != null) {

            for (int i = 0; i < list.size(); i++) {

                categoryBehind = list.get(i).getCategory();
                sumanBehind = list.get(i).getSuman();
                sumb1nBehind = list.get(i).getSumb1n();
                sumb2nBehind = list.get(i).getSumb2n();
                sumcnBehind = list.get(i).getSumcn();
                sumdnBehind = list.get(i).getSumdn();
                sumenBehind = list.get(i).getSumen();
                sumasBehind = list.get(i).getSumas();
                sumb1sBehind = list.get(i).getSumb1s();
                sumb2sBehind = list.get(i).getSumb2s();
                sumcsBehind = list.get(i).getSumcs();
                sumdsBehind = list.get(i).getSumds();
                sumesBehind = list.get(i).getSumes();

                sumBnBehind = sumb1nBehind + sumb2nBehind;
                sumBsBehind = sumb1sBehind + sumb2sBehind;

            }

            return list;
        } else {
            return null;
        }
    }

    public Boolean isNeedDateTime(String date) {

        Boolean isNeedDate = false;

        String Sql = "select * from Birthdate where startdate like '" + date + "%' or enddate like '" + date + "%';";

        List<Birthdate> list = this.findSql(Sql);

        if (list.size() > 0) {
            isNeedDate = true;
        } else {
            isNeedDate = false;
        }

        return isNeedDate;

    }
}
