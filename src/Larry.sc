;;; Sierra Script 1.0 - (do not remove this comment)
(script# 23)
(include sci.sh)
(use Main)
(use StopWalk)
(use InvI)
(use User)


(class Larry of Ego
	(properties
		x 0
		y 0
		z 0
		heading 0
		noun 0
		nsTop 0
		nsLeft 0
		nsBottom 0
		nsRight 0
		description {Larry}
		sightAngle 180
		actions 0
		onMeCheck $6789
		approachX 0
		approachY 0
		approachDist 0
		_approachVerbs 26505
		lookStr 0
		yStep 2
		view 550
		loop 0
		cel 0
		priority 0
		underBits 0
		signal $2000
		lsTop 0
		lsLeft 0
		lsBottom 0
		lsRight 0
		brTop 0
		brLeft 0
		brBottom 0
		brRight 0
		palette 0
		cycleSpeed 6
		script 0
		cycler 0
		timer 0
		detailLevel 0
		illegalBits $8000
		xLast 0
		yLast 0
		xStep 3
		moveSpeed 6
		blocks 0
		baseSetter 0
		mover 0
		looper 0
		viewer 0
		avoider 0
		code 0
		edgeHit 0
		skating 0
		sitting 0
	)
	
	(method (doVerb theVerb param2 &tmp [temp0 80])
		(switch theVerb
			(2
				(if skating (proc0_14 23 0) else (proc0_14 23 1))
			)
			(5 (proc0_14 23 2))
			(3
				(proc0_14 23 3)
				(proc0_14 23 4 67 -1 185)
			)
			(10 (proc0_14 23 5))
			(4
				(switch param2
					(0 (proc0_14 23 6))
					(6 (proc0_14 23 7))
					(12 (proc0_14 23 8))
					(16
						(proc0_14 23 9)
						(proc0_14 23 10 67 -1 185)
					)
					(18 ((Inv at: 18) doVerb: 3))
					(20 (proc0_14 23 11))
					(22 ((Inv at: 22) doVerb: 3))
					(else 
						(Format @temp0 23 12 ((Inv at: param2) description?))
						(proc0_14 @temp0)
					)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
	
	(method (get param1 &tmp temp0)
		(= temp0 0)
		(while (< temp0 argc)
			((gInv at: [param1 temp0]) moveTo: 23)
			(++ temp0)
		)
	)
	
	(method (has param1 &tmp temp0)
		(if (= temp0 (gInv at: param1)) (temp0 ownedBy: 23))
	)
	
	(method (normalize param1)
		(= view (if argc param1 else 550))
		(self
			setLoop: -1
			setCel: -1
			setPri: -1
			setMotion: 0
			setCycle: StopWalk -1
			setStep: 3 2
			z: 0
			illegalBits: -32768
			ignoreActors: 0
			moveSpeed: (gGame egoMoveSpeed?)
			cycleSpeed: (gGame egoMoveSpeed?)
		)
	)
	
	(method (setUpInv)
		((ScriptID 19 0) doit: 23)
	)
	
	(method (showInv)
		(if (Inv firstTrue: #ownedBy 23)
			(Inv showSelf: 23)
			(if (not (gIconBar curInvIcon?))
				(gIconBar curIcon: (gIconBar at: 0) disable: 6)
				(gGame setCursor: ((gIconBar curIcon?) cursor?))
			)
		else
			(proc0_14 23 13)
		)
	)
)
