package io.javabrains.coronavirustracker.controllers;
import io.javabrains.coronavirustracker.models.*;

import io.javabrains.coronavirustracker.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class HomeController {

   @Autowired
   CoronaVirusDataService coronaVirusDataService;

   private static Map<Integer,Products> productRepo = new HashMap<>();
   static{
      Products HTF = new Products();
      HTF.setId(1);
      HTF.setName("Hospital Tuanku Fauziah, Kangar");
      HTF.setState("Perlis");
      productRepo.put(HTF.getId(), HTF);

      Products HSB = new Products();
      HSB.setId(2);
      HSB.setName("Hospital Sultanah Bahiyah, Alor Setar");
      HSB.setState("Kedah");
      productRepo.put(HSB.getId(), HSB);

      Products HSM = new Products();
      HSM.setId(3);
      HSM.setName("Hospital Sultanah Maliha, Langkawi");
      HSM.setState("Kedah");
      productRepo.put(HSM.getId(), HSM);

      Products HKN = new Products();
      HKN.setId(4);
      HKN.setName("Hospital Kuala Nerang");
      HKN.setState("Kedah");
      productRepo.put(HKN.getId(), HKN);

      Products HPP = new Products();
      HPP.setId(5);
      HPP.setName("Hospital Pulau Pinang");
      HPP.setState("Pulau Pinang");
      productRepo.put(HPP.getId(), HPP);

      Products HKB = new Products();
      HKB.setId(6);
      HKB.setName("Hospital Kepala Batas");
      HKB.setState("Pulau Pinang");
      productRepo.put(HKB.getId(), HKB);

      Products HRPBI = new Products();
      HRPBI.setId(7);
      HRPBI.setName("Hospital Raja Permaisuri Bainun, Ipoh");
      HRPBI.setState("Perak");
      productRepo.put(HRPBI.getId(), HRPBI);

      Products HTI = new Products();
      HTI.setId(8);
      HTI.setName("Hospital Teluk Intan");
      HTI.setState("Perak");
      productRepo.put(HTI.getId(), HTI);

      Products HSR = new Products();
      HSR.setId(9);
      HSR.setName("Hospital Slim River");
      HSR.setState("Perak");
      productRepo.put(HSR.getId(), HSR);

      Products HSMP = new Products();
      HSMP.setId(10);
      HSMP.setName("Hospital Seri Manjung");
      HSMP.setState("Perak");
      productRepo.put(HSMP.getId(), HSMP);

      Products HTP = new Products();
      HTP.setId(11);
      HTP.setName("Hospital Taiping");
      HTP.setState("Perak");
      productRepo.put(HTP.getId(), HTP);

      Products HSBS = new Products();
      HSBS.setId(12);
      HSBS.setName("Hospital Sungai Buloh");
      HSBS.setState("Selangor");
      productRepo.put(HSBS.getId(), HSBS);

      Products HKL = new Products();
      HKL.setId(13);
      HKL.setName("Hospital Kuala Lumpur");
      HKL.setState("Wilayah Persekutuan Kuala Lumpur/Putrajaya");
      productRepo.put(HKL.getId(), HKL);

      Products HTJ = new Products();
      HTJ.setId(14);
      HTJ.setName("Hospital Sultanah Maliha");
      HTJ.setState("Negeri Sembilan");
      productRepo.put(HTJ.getId(), HTJ);

      Products HR = new Products();
      HR.setId(15);
      HR.setName("Hospital Rembau");
      HR.setState("Negeri Sembilan");
      productRepo.put(HR.getId(), HR);

      Products HT = new Products();
      HT.setId(16);
      HT.setName("Hospital Tampin");
      HT.setState("Negeri Sembilan");
      productRepo.put(HT.getId(), HT);

      Products HM = new Products();
      HM.setId(17);
      HM.setName("Hospital Melaka");
      HM.setState("Melaka");
      productRepo.put(HM.getId(), HM);

      Products HESBHK = new Products();
      HESBHK.setId(18);
      HESBHK.setName("Hospital Enche Besar Hajjah Kalsom");
      HESBHK.setState("Johor");
      productRepo.put(HESBHK.getId(), HESBHK);

      Products HP = new Products();
      HP.setId(19);
      HP.setName("Hospital Permai");
      HP.setState("Johor");
      productRepo.put(HP.getId(), HP);

      Products HSA = new Products();
      HSA.setId(20);
      HSA.setName("Hospital Sultanah Aminah");
      HSA.setState("Johor");
      productRepo.put(HSA.getId(), HSA);

      Products HTAA = new Products();
      HTAA.setId(21);
      HTAA.setName("Hospital Tengku Ampuan Afzan");
      HTAA.setState("Pahang");
      productRepo.put(HTAA.getId(), HTAA);

      Products HSHAS = new Products();
      HSHAS.setId(22);
      HSHAS.setName("Hospital Sultan Haji Ahmad Shah, Temerloh");
      HSHAS.setState("Pahang");
      productRepo.put(HSHAS.getId(), HSHAS);

      Products HKLI = new Products();
      HKLI.setId(23);
      HKLI.setName("Hospital Kuala Lipis");
      HKLI.setState("Pahang");
      productRepo.put(HKLI.getId(), HKLI);

      Products HSNZKT = new Products();
      HSNZKT.setId(24);
      HSNZKT.setName("Hospital Sultanah Nur Zahirah, Kuala Terengganu");
      HSNZKT.setState("Terengganu");
      productRepo.put(HSNZKT.getId(), HSNZKT);

      Products HHT = new Products();
      HHT.setId(25);
      HHT.setName("Hospital Hulu Terengganu");
      HHT.setState("Terengganu");
      productRepo.put(HHT.getId(), HHT);

      Products HRPZIIKB = new Products();
      HRPZIIKB.setId(26);
      HRPZIIKB.setName("Hospital Raja Perempuan Zainab II, Kota Bharu");
      HRPZIIKB.setState("Kelantan");
      productRepo.put(HRPZIIKB.getId(), HRPZIIKB);

      Products HSIPKK = new Products();
      HSIPKK.setId(27);
      HSIPKK.setName("Hospital Sultan Ismail Petra, Kuala Krai");
      HSIPKK.setState("Kelantan");
      productRepo.put(HSIPKK.getId(), HSIPKK);

      Products HKKL = new Products();
      HKKL.setId(28);
      HKKL.setName("Hospital Kuala Krai (Lama)");
      HKKL.setState("Kelantan");
      productRepo.put(HKKL.getId(), HKKL);

      Products HTK = new Products();
      HTK.setId(29);
      HTK.setName("Hospital Tumpat");
      HTK.setState("Kelantan");
      productRepo.put(HTK.getId(), HTK);

      Products HTM = new Products();
      HTM.setId(30);
      HTM.setName("Hospital Tanah Merah");
      HTM.setState("Kelantan");
      productRepo.put(HTM.getId(), HTM);

      Products HQEKK = new Products();
      HQEKK.setId(31);
      HQEKK.setName("Hospital Queen Elizabeth I, Kota Kinabalu");
      HQEKK.setState("Sabah");
      productRepo.put(HQEKK.getId(), HQEKK);

      Products HDOKS = new Products();
      HDOKS.setId(32);
      HDOKS.setName("Hospital Duchess Of Kent, Sandakan");
      HDOKS.setState("Sabah");
      productRepo.put(HDOKS.getId(), HDOKS);

      Products HTAW = new Products();
      HTAW.setId(33);
      HTAW.setName("Hospital Tawau");
      HTAW.setState("Sabah");
      productRepo.put(HTAW.getId(), HTAW);

      Products HWDKKL = new Products();
      HWDKKL.setId(34);
      HWDKKL.setName("Hospital Wanita dan Kanak-kanak, Likas");
      HWDKKL.setState("Sabah");
      productRepo.put(HWDKKL.getId(), HWDKKL);

      Products HLD = new Products();
      HLD.setId(35);
      HLD.setName("Hospital Lahad Datu");
      HLD.setState("Sabah");
      productRepo.put(HLD.getId(), HLD);

      Products HK = new Products();
      HK.setId(36);
      HK.setName("Hospital Keningau");
      HK.setState("Sabah");
      productRepo.put(HK.getId(), HK);

      Products HKM = new Products();
      HKM.setId(37);
      HKM.setName("Hospital Kota Marudu");
      HKM.setState("Sabah");
      productRepo.put(HKM.getId(), HKM);

      Products HKU = new Products();
      HKU.setId(38);
      HKU.setName("Hospital Kudat");
      HKU.setState("Sabah");
      productRepo.put(HKU.getId(), HKU);

      Products HS = new Products();
      HS.setId(39);
      HS.setName("Hospital Semporna");
      HS.setState("Sabah");
      productRepo.put(HS.getId(), HS);

      Products HUSK = new Products();
      HUSK.setId(40);
      HUSK.setName("Hospital Umu Sarawak, Kuching");
      HUSK.setState("Sabah");
      productRepo.put(HUSK.getId(), HUSK);

      Products HMS = new Products();
      HMS.setId(41);
      HMS.setName("Hospital Miri");
      HMS.setState("Sabah");
      productRepo.put(HMS.getId(), HMS);

      Products HB = new Products();
      HB.setId(42);
      HB.setName("Hospital Bintulu");
      HB.setState("Sabah");
      productRepo.put(HB.getId(), HB);

      Products HSS = new Products();
      HSS.setId(43);
      HSS.setName("Hospital Sibu");
      HSS.setState("Sabah");
      productRepo.put(HSS.getId(), HSS);

      Products HL = new Products();
      HL.setId(44);
      HL.setName("Hospital Labuan");
      HL.setState("WP Labuan");
      productRepo.put(HL.getId(), HL);
   }

   @GetMapping("/")
   public String home(Model model) {
      List<LocationStats> allStats = coronaVirusDataService.getAllStats();
      int totalReportedCases = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
      int totalNewCases = allStats.stream().mapToInt(stat -> stat.getDiffFromPrevDay()).sum();
      model.addAttribute("locationStats", allStats);
      model.addAttribute("totalReportedCases", totalReportedCases);
      model.addAttribute("totalNewCases", totalNewCases);
      return "home";
   }

   @RequestMapping(value = "/products", method = RequestMethod.GET)
   public ResponseEntity<Object> getProduct() {
      return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
   }

   @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
   public ResponseEntity<Object> delete(@PathVariable("id") Integer id) {
      productRepo.remove(id);
      return new ResponseEntity<>("Products is deleted successsfully", HttpStatus.OK);
   }

}
