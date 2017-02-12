package hib.service.impl;

import hib.ora.dao.BaseDAO;
import hib.ora.entity.Birthdate;
import hib.ora.entity.Casetable;
import hib.service.CasetableService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("CasetableService")
public class CasetableServiceImpl implements CasetableService {
    @Autowired
    BaseDAO<Casetable> baseDAO;

    BirthdateServiceImpl birthdateService;

    @Override
    public List<Casetable> find(String hql) {

        return baseDAO.find(hql);
    }

    @Override
    public List<Casetable> find(String hql, List<Object> param) {

        return baseDAO.find(hql, param);

    }

    @Override
    public void update(String hql, List<Object> param) {

        baseDAO.update(hql, param);

    }

    @Override
    public void update(Casetable casetable) {

        baseDAO.update(casetable);

    }


    public Casetable dealwithFront(String date, String hemisphere, Birthdate birdateInfo) {

        int A = 0;
        int B = 0;
        int C = 0;
        int D = 0;
        int E = 0;

        if (hemisphere.equalsIgnoreCase("N")) {
            A = birdateInfo.getSuman();
            B = birdateInfo.getSumb1n() + birdateInfo.getSumb2n();
            C = birdateInfo.getSumcn();
            D = birdateInfo.getSumdn();
            E = birdateInfo.getSumen();
        } else {
            A = birdateInfo.getSumas();
            B = birdateInfo.getSumb1s() + birdateInfo.getSumb2s();
            C = birdateInfo.getSumcn();
            D = birdateInfo.getSumdn();
            E = birdateInfo.getSumen();
        }

        String Hql = "";
        List<Object> param = new ArrayList<Object>();

        Map<String, Integer> map = new HashMap<String, Integer>();

        map.put("A", A);
        map.put("B", B);
        map.put("C", C);
        map.put("D", D);
        map.put("E", E);

        List<Map.Entry<String, Integer>> infoIds =
                new ArrayList<Map.Entry<String, Integer>>(map.entrySet());

        //排序前
//     	for (int i = 0; i < infoIds.size(); i++) {
//     	    String id = infoIds.get(i).toString();
//     	    System.out.println(id);
//     	}

        //排序
        Collections.sort(infoIds, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue() - o1.getValue());
                //return (o1.getKey()).toString().compareTo(o2.getKey());
            }
        });

        String max = infoIds.get(0).toString();
        String arg[] = max.split("=");
        String xa = arg[0];
        int xaValue = Integer.valueOf(arg[1]).intValue();

        String maxb = infoIds.get(1).toString();
        String argb[] = maxb.split("=");
        String xb = argb[0];
        int xbValue = Integer.valueOf(argb[1]).intValue();

        if (xaValue == 4) {
            Hql = "from Casetable where maincase = 'A3' and subcase = ?";
            param.add("4" + xa);
        } else if (xaValue == 3) {
            Hql = "from Casetable where maincase = 'D3' and subcase = ?";
            if (xbValue == 2) {
                param.add("3" + xa + "2" + xb);
            } else {
                Hql = "from Casetable where maincase = 'B3' and subcase = ?";
                param.add("3" + xa);
            }

        } else if (xaValue == 2) {
            Hql = "from Casetable where maincase = 'E3' and subcase = ?";
            if (xbValue == 2) {
                param.add("2" + xa + "2" + xb);
            } else {
                Hql = "from Casetable where maincase = 'C3' and subcase = ?";
                param.add("2" + xa);
            }
        } else {
            Hql = "from Casetable where maincase = 'F3' and subcase = 'F3'";
            param = null;
        }


//    	if (suman == 4) {
//    		Hql = "from Casetable where maincase = 'A3' and subcase = ?";
//    		param.add("4A");
//    	}
//    	else if (suman == 3) {
//    		Hql = "from Casetable where maincase = 'D3' and subcase = ?";
//            if (sumBn == 2) {
//            	param.add("3A2B");
//    		}
//			else if (sumcn == 2) {
//				param.add("3A2C");		
//			}
//			else if (sumdn == 2) {
//				param.add("3A2D");
//			}
//            else if (sumen == 2) {
//            	param.add("3A2E");
//			}
//            else {
//            	Hql = "from Casetable where maincase = 'B3' and subcase = '3A'";
//            	param = null;
//            }
//    	}
//    	else if (suman == 2) {
//    		Hql = "from Casetable where maincase = 'E3' and subcase = ?";
//    		if (sumBn == 2) {
//            	param.add("2A2B");
//    		}
//			else if (sumcn == 2) {
//				param.add("2A2C");		
//			}
//			else if (sumdn == 2) {
//				param.add("2A2D");
//			}
//            else if (sumen == 2) {
//            	param.add("2A2E");
//			}
//            else {
//            	Hql = "from Casetable where maincase = 'C3' and subcase = '2A'";
//            	param = null;
//            }
//    	}
//    	else {
//    		Hql = "from Casetable where maincase = 'F3' and subcase = 'F3'";
//    		param = null;
//    	}

        List<Casetable> list = this.find(Hql, param);

        if (list.size() > 0)
            return list.get(0);
        else
            return null;

    }

    public Casetable dealwithBehind(String date, String hemisphere, Birthdate birdateInfo, Birthdate sysdateInfo) {

        int A = 0;
        int B = 0;
        int C = 0;
        int D = 0;
        int E = 0;

        if (hemisphere.equalsIgnoreCase("N") || hemisphere.equalsIgnoreCase("north")) {
            A = birdateInfo.getSuman() + sysdateInfo.getSuman();
            B = birdateInfo.getSumb1n() + birdateInfo.getSumb2n() + sysdateInfo.getSumb1n() + sysdateInfo.getSumb2n();
            C = birdateInfo.getSumcn() + sysdateInfo.getSumcn();
            D = birdateInfo.getSumdn() + sysdateInfo.getSumdn();
            E = birdateInfo.getSumen() + sysdateInfo.getSumen();
        } else {
            A = birdateInfo.getSumas() + sysdateInfo.getSumas();
            B = birdateInfo.getSumb1s() + birdateInfo.getSumb2s() + sysdateInfo.getSumb1s() + sysdateInfo.getSumb2s();
            C = birdateInfo.getSumcs() + sysdateInfo.getSumcs();
            D = birdateInfo.getSumds() + sysdateInfo.getSumds();
            E = birdateInfo.getSumes() + sysdateInfo.getSumes();
        }

        String Hql = "";
        List<Object> param = new ArrayList<Object>();

        int maxValue1 = 0;
        int maxValue2 = 0;
        int maxValue3 = 0;

        String maxStr1 = null;
        String maxStr2 = null;
        String maxStr3 = null;

        Map<String, Integer> map = new HashMap<String, Integer>();

        map.put("A", A);
        map.put("B", B);
        map.put("C", C);
        map.put("D", D);
        map.put("E", E);

        List<Map.Entry<String, Integer>> infoIds =
                new ArrayList<Map.Entry<String, Integer>>(map.entrySet());

        //排序
        Collections.sort(infoIds, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue() - o1.getValue());
                //return (o1.getKey()).toString().compareTo(o2.getKey());
            }
        });

        //取三个最大的值

        String max1 = infoIds.get(0).toString();
        String arg[] = max1.split("=");
        maxStr1 = arg[0];
        maxValue1 = Integer.valueOf(arg[1]).intValue();

        String max2 = infoIds.get(1).toString();
        String arg2[] = max2.split("=");
        maxStr2 = arg2[0];
        maxValue2 = Integer.valueOf(arg2[1]).intValue();

        String max3 = infoIds.get(2).toString();
        String arg3[] = max3.split("=");
        maxStr3 = arg3[0];
        maxValue3 = Integer.valueOf(arg3[1]).intValue();

        if (maxValue1 == 8) {
            Hql = "from Casetable where maincase = 'A4' and subcase = ?";
            param.add("8" + maxStr1);
        } else if (maxValue1 == 7) {
            Hql = "from Casetable where maincase = 'A4' and subcase = ?";
            param.add("7" + maxStr1);
        } else if (maxValue1 == 6) {
            if (maxValue2 == 4) {
                Hql = "from Casetable where maincase = 'B4' and subcase = ?";
                param.add("6" + maxStr1 + "4" + maxStr2);
            } else if (maxValue2 == 3) {
                Hql = "from Casetable where maincase = 'C4' and subcase = ?";
                param.add("6" + maxStr1 + "3" + maxStr2);
            } else {
                Hql = "from Casetable where maincase = 'A4' and subcase = ?";
                param.add("6" + maxStr1);
            }
        } else if (maxValue1 == 5) {
            if (maxValue2 == 4) {
                Hql = "from Casetable where maincase = 'D4' and subcase = ?";
                param.add("5" + maxStr1 + "4" + maxStr2);
            } else if (maxValue2 == 3) {
                Hql = "from Casetable where maincase = 'E4' and subcase = ?";
                param.add("5" + maxStr1 + "3" + maxStr2);
            } else {
                Hql = "from Casetable where maincase = 'A4' and subcase = ?";
                param.add("5" + maxStr1);
            }
        } else if (maxValue1 == 4) {
            if (maxValue2 == 4) {
                Hql = "from Casetable where maincase = 'F4' and subcase = ?";
                param.add("4" + maxStr1 + "4" + maxStr2);
            } else if (maxValue2 == 3 && maxValue3 < 3) {
                Hql = "from Casetable where maincase = 'G4' and subcase = ?";
                param.add("4" + maxStr1 + "3" + maxStr2);
            } else if (maxValue2 == 3 && maxValue3 == 3) {
                Hql = "from Casetable where maincase = 'H4' and subcase like ?";
                param.add("4" + maxStr1 + "3" + maxStr2 + "3" + maxStr3);
            } else if (maxValue2 == 2) {
                Hql = "from Casetable where maincase = 'A4' and subcase = ?";
                param.add("4" + maxStr1);
            }
        } else if (maxValue1 == 3) {
            if (maxValue2 == 3 && maxValue3 < 3) {
                Hql = "from Casetable where maincase = 'B4' and subcase like ?";
                param.add("3" + maxStr1 + "3" + maxStr2);
            } else if (maxValue2 == 3 && maxValue3 == 3) {
                Hql = "from Casetable where maincase = 'C4' and subcase like ?";
                param.add("3" + maxStr1 + "3" + maxStr2 + "3" + maxStr3);
            } else if (maxValue2 == 2) {
                Hql = "from Casetable where maincase = 'A4' and subcase = ?";
                param.add("3" + maxStr1);
            }
        } else {
            Hql = "from Casetable where maincase = 'K4' and subcase = 'K4'";
            param = null;
        }

        List<Casetable> list = this.find(Hql, param);

        if (list.size() > 0)
            return list.get(0);
        else
            return null;

    }


    public void updateCaseElement(String key, String value, String m, String s) {

        String Hql = "update Casetable c set c." + key + "= ? where c.maincase=? and c.subcase=?";

        List<Object> param = new ArrayList<Object>();

        param.add(value);

        param.add(m);

        param.add(s);

        this.update(Hql, param);

    }

    public List<Casetable> findAllCase() {

        String Hql = "from Casetable";

        List<Casetable> list = this.find(Hql);

        return list;
    }

    public List<Casetable> findCaseWithFilter(String m, String s) {

        String Hql = "from Casetable c where c.maincase=? and c.subcase=?";

        List<Object> param = new ArrayList<Object>();

        param.add(m);

        param.add(s);

        List<Casetable> list = this.find(Hql, param);

        return list;
    }

    public String dealWithCaseSum(String date, String hemisphere, Birthdate birdateInfo, Birthdate sysdateInfo) {

        String A = "";
        String B = "";
        String C = "";
        String D = "";
        String E = "";

        if (hemisphere.equalsIgnoreCase("north")) {
            A = String.valueOf(birdateInfo.getSuman() + sysdateInfo.getSuman());
            B = String.valueOf(birdateInfo.getSumb1n() + sysdateInfo.getSumb1n() + birdateInfo.getSumb2n() + sysdateInfo.getSumb2n());
            C = String.valueOf(birdateInfo.getSumcn() + sysdateInfo.getSumcn());
            D = String.valueOf(birdateInfo.getSumdn() + sysdateInfo.getSumdn());
            E = String.valueOf(birdateInfo.getSumen() + sysdateInfo.getSumen());
        } else {
            A = String.valueOf(birdateInfo.getSumas() + sysdateInfo.getSumas());
            B = String.valueOf(birdateInfo.getSumb1s() + sysdateInfo.getSumb1s() + birdateInfo.getSumb2s() + sysdateInfo.getSumb2s());
            C = String.valueOf(birdateInfo.getSumcs() + sysdateInfo.getSumcs());
            D = String.valueOf(birdateInfo.getSumds() + sysdateInfo.getSumds());
            E = String.valueOf(birdateInfo.getSumes() + sysdateInfo.getSumes());
        }
        String caseInfo = A + B + C + D + E;
        return caseInfo;
    }

}
