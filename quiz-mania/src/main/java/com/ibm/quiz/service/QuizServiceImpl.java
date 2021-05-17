package com.ibm.quiz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.quiz.entity.Option;
import com.ibm.quiz.entity.Question;
import com.ibm.quiz.entity.Quiz;
import com.ibm.quiz.entity.User;
import com.ibm.quiz.repo.OptionRepository;
import com.ibm.quiz.repo.QuestionRepository;
import com.ibm.quiz.repo.QuizRepository;

@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	private QuizRepository zrepo;
	
	@Autowired
	private QuestionRepository qrepo;
	
	@Autowired
	private OptionRepository orepo;
	
	@Override
	public int addQuiz(Quiz quiz) {
		zrepo.save(quiz);
		return quiz.getQcode();
	}

	@Override
	public Quiz getQuiz(int qcode) {
		return zrepo.findById(qcode).get();
	}

	@Override
	public int addQuestion(Question que, int qcode) {
		Quiz quiz = zrepo.findById(qcode).get();
		quiz.getQuestions().add(que);
		que.setQuiz(quiz);
		qrepo.save(que);
		return que.getQid();
	}

	@Override
	public Question getQuestion(int qid) {
		return qrepo.findById(qid).get();
	}

	@Override
	public int addOption(Option opt, int qid) {
		Question question = qrepo.findById(qid).get();
		question.getOptions().add(opt);
		opt.setQue(question);
		orepo.save(opt);
		return opt.getOpid();
	}

	@Override
	public String submitQuiz(Quiz q) {

		int totalQuestion = q.getQuestions().size();
		int result = 0;
		
		for(Question que : q.getQuestions()) {
			for(Option op : que.getOptions()) {
				int res = op.getFlag();
				if(res == 1 && (op.getOption() == que.getAnswer()) )
						++result;
			}
		}
	
		double percent = (result * 100) / totalQuestion;
		if( percent  < 75.0 ) {
//			System.out.println("Result: Fail");
//			System.out.println("Total questions: " + totalQuestion + "\tCorrect answers: " + result + "\t Percent: " + percent + "%");
			return "Percent: " + percent + "\tResult: FAIL";
		}			
		else {
//			System.out.println("Result: Pass");
//			System.out.println("Total questions: " + totalQuestion + "\tCorrect answers: " + result + "\t Percent: " + percent + "%");
			return "Percent: " + percent + "\tResult: PASS";
		}
	}

}
